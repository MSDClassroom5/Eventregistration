package com.Eventregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;

@SpringBootApplication
public class EventregistrationApplication {

	public static void main(String[] args) {
		System.out.println("MSD Project group 5::Starting API application");
		SpringApplication.run(EventregistrationApplication.class, args);
	}
	@Bean
	public static JaegerTracer getTracer() {
		Configuration.SamplerConfiguration samplerConfig =
				Configuration .SamplerConfiguration.fromEnv().withType("const").withParam(1);
		Configuration.ReporterConfiguration reporterConfig =
		Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
		Configuration config = new Configuration("jaeger tutorial").withSampler(samplerConfig).withReporter(reporterConfig);
		return config.getTracer();			
	}

}
