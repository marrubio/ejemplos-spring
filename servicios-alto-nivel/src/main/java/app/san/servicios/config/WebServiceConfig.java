package app.san.servicios.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/ws/*");
  }

  @Bean(name = "usuarios")
  public DefaultWsdl11Definition usuarios(XsdSchema usuariosSchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("UsersPort");
    wsdl11Definition.setLocationUri("/ws/usuarios");
    wsdl11Definition.setTargetNamespace("http://san.app/servicios/ws/usuarios");
    wsdl11Definition.setSchema(usuariosSchema);
    return wsdl11Definition;
  }

  
  @Bean
  public XsdSchema usuariosSchema() {
    return new SimpleXsdSchema(new ClassPathResource("usuarios.xsd"));
  }

  @Bean
  public ModelMapper modelMapper() {
      return new ModelMapper();
  }
  
}