package org.aibles.configserver.exception;

import java.util.Map;

public class ExceptionRequest extends RuntimeException{

  private int status;
  private String code;
  private Map<String, Object> params;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public void addParams(String key, Object value) {
    this.params.put(key, value);
  }

}
