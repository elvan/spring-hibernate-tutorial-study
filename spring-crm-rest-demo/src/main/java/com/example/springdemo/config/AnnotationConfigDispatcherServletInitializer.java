package com.example.springdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AnnotationConfigDispatcherServletInitializer extends
  AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {
      DemoAppConfig.class
    };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {
      "/"
    };
  }

}
