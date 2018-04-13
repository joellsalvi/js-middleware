package br.com.middleware.integration.api.logger;

import feign.Logger;
import feign.Request;
import feign.Response;
import feign.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

public class JMSlf4jLogger extends Logger {
    private final org.slf4j.Logger logger;

    public JMSlf4jLogger() {
        this(Logger.class);
    }

    public JMSlf4jLogger(Class<?> clazz) {
        this(LoggerFactory.getLogger(clazz));
    }

    public JMSlf4jLogger(String name) {
        this(LoggerFactory.getLogger(name));
    }

    JMSlf4jLogger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    protected void logRequest(String configKey, Level logLevel, Request request) {
        if (this.logger.isDebugEnabled()) {
            this.logRequestOneLine(configKey, logLevel, request);
        }

    }

    private String logLine(String format, Object... args) {
        return String.format(format, args) + "\n";
    }

    private void logRequestOneLine(String configKey, Level logLevel, Request request) {
        List<String> requestLog = new LinkedList();
        requestLog.add(this.logLine("---> %s %s HTTP/1.1", request.method(), EncodeUtils.decode(request.url())));
        if (logLevel.ordinal() >= Level.HEADERS.ordinal()) {
            Iterator var5 = request.headers().keySet().iterator();

            String bodyText;
            while(var5.hasNext()) {
                bodyText = (String)var5.next();
                Iterator var7 = Util.valuesOrEmpty(request.headers(), bodyText).iterator();

                while(var7.hasNext()) {
                    String value = (String)var7.next();
                    requestLog.add(this.logLine("%s: %s", bodyText, value));
                }
            }

            int bodyLength = 0;
            if (request.body() != null) {
                bodyLength = request.body().length;
                if (logLevel.ordinal() >= Level.FULL.ordinal()) {
                    bodyText = request.charset() != null ? new String(request.body(), request.charset()) : null;
                    requestLog.add(this.logLine(""));
                    requestLog.add(this.logLine("%s", bodyText != null ? bodyText : "Binary data"));
                }
            }

            requestLog.add(this.logLine("---> END HTTP (%s-byte body)", bodyLength));
        }

        this.log(configKey, (String)requestLog.stream().collect(Collectors.joining("")));
    }

    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        return this.logger.isDebugEnabled() ? this.logAndRebufferResponseOneLine(configKey, logLevel, response, elapsedTime) : response;
    }

    private Response logAndRebufferResponseOneLine(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        List<String> responseLog = new LinkedList();
        String reason = response.reason() != null && logLevel.compareTo(Level.NONE) > 0 ? " " + response.reason() : "";
        responseLog.add(this.logLine("<--- HTTP/1.1 %s%s (%sms)", response.status(), reason, elapsedTime));
        if (logLevel.ordinal() >= Level.HEADERS.ordinal()) {
            Iterator var8 = response.headers().keySet().iterator();

            while(var8.hasNext()) {
                String field = (String)var8.next();
                Iterator var10 = Util.valuesOrEmpty(response.headers(), field).iterator();

                while(var10.hasNext()) {
                    String value = (String)var10.next();
                    responseLog.add(this.logLine("%s: %s", field, value));
                }
            }

            int bodyLength = 0;
            if (response.body() != null) {
                if (logLevel.ordinal() >= Level.FULL.ordinal()) {
                    responseLog.add(this.logLine(""));
                }

                byte[] bodyData = Util.toByteArray(response.body().asInputStream());
                bodyLength = bodyData.length;
                if (logLevel.ordinal() >= Level.FULL.ordinal() && bodyLength > 0) {
                    responseLog.add(this.logLine("%s", decodeOrDefault(bodyData, Util.UTF_8, "Binary data")));
                }

                responseLog.add(this.logLine("<--- END HTTP (%s-byte body)", bodyLength));
                this.log(configKey, (String)responseLog.stream().collect(Collectors.joining("")));
                return Response.create(response.status(), response.reason(), response.headers(), bodyData);
            }

            responseLog.add(this.logLine("<--- END HTTP (%s-byte body)", Integer.valueOf(bodyLength)));
            this.log(configKey, (String)responseLog.stream().collect(Collectors.joining("")));
        }

        return response;
    }

    protected void log(String configKey, String format, Object... args) {
        String message = methodTag(configKey) + format;

        try {
            this.logger.debug(String.format(message, args));
        } catch (Exception var6) {
            this.logger.error("Error logging formatted message.", var6);
            this.logger.debug(message);
        }

    }

    static String decodeOrDefault(byte[] data, Charset charset, String defaultValue) {
        if (data == null) {
            return defaultValue;
        } else {
            Util.checkNotNull(charset, "charset", new Object[0]);

            try {
                return charset.newDecoder().decode(ByteBuffer.wrap(data)).toString();
            } catch (CharacterCodingException var4) {
                return defaultValue;
            }
        }
    }
}
