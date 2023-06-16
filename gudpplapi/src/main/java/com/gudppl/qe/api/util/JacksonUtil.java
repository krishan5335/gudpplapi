package com.gudppl.qe.api.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gudppl.qe.api.response.ResponseBase;
import com.gudppl.qe.api.request.RequestBase;

import java.io.IOException;
import java.util.Arrays;


public class JacksonUtil {

    public static String getAsString(RequestBase requestBase) {
        return getAsString(requestBase, true);
    }

    public static final String getAsString(RequestBase body, boolean ignoreNull) {
        ObjectMapper mapper = new ObjectMapper();
        if (ignoreNull)
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            jsonInString = Arrays.toString(e.getStackTrace());
            //Log.logException(e);
        }
        return jsonInString;
    }

    public static String getAsArrayString(RequestBase... requestBase) {
        return getAsArrayString(true, requestBase);
    }

    public static String getAsArrayString(boolean ignoreNull, RequestBase... requestBase) {
        ObjectMapper mapper = new ObjectMapper();
        if (ignoreNull)
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(requestBase);
        } catch (JsonProcessingException e) {
            jsonInString = Arrays.toString(e.getStackTrace());
            //Log.logException(e);
        }
        return jsonInString;
    }

    public static RequestBase getRequestAsObject(String jsonString, boolean ignoreNull) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (ignoreNull)
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue(jsonString, RequestBase.class);
    }

    public static ResponseBase getResponseAsObject(String jsonString, boolean ignoreNull) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (ignoreNull)
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue(jsonString, ResponseBase.class);
    }

    public static ResponseBase getResponseAsObject(String jsonString, boolean ignoreNull, Class<?> cls) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            if (ignoreNull) {
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            }

            return (ResponseBase) mapper.readValue(jsonString, cls);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;

    }

    public static <R> Object getResponseAsObject(String response, Class<R> classType) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return mapper.readValue(response, classType);
        } catch (JsonProcessingException e) {
            return null;
        } catch (IOException e) {

            return null;
        }
    }


}
