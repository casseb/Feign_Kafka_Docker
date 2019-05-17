package com.bycasseb.appaz.config;

import com.bycasseb.appaz.stream.EnderecoStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(EnderecoStream.class)
public class StreamsConfig {
}
