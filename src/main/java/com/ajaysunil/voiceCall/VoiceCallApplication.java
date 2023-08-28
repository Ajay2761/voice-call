package com.ajaysunil.voiceCall;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
@SpringBootApplication
public class VoiceCallApplication implements ApplicationRunner{
	private final static String SID_ACCOUNT="AC97b33f03c013ea6684a9bd0d8d16528b";
	private final static String AUTH_ID="083a7e2614ccb7380cd4dc74c2eec35a";
	private final static String FROM_NUMBER="888-111-1020";
	private final static String TO_NUMBER="9390163788";

	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
	}



	public static void main(String[] args) {
		SpringApplication.run(VoiceCallApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER),new PhoneNumber(FROM_NUMBER),
				new URI("http://demo.twilio.com/doc/voice.xml")).create();
	}
}
