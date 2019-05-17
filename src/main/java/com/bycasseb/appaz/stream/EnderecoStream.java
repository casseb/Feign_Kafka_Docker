package com.bycasseb.appaz.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EnderecoStream {

    String INPUT = "endereco-in";
    String OUTPUT = "endereco-out";

    @Input(INPUT)
    SubscribableChannel inboundEndereco();

    @Output(OUTPUT)
    MessageChannel outboundEndereco();
}
