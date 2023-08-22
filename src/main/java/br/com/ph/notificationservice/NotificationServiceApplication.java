package br.com.ph.notificationservice;

import br.com.ph.notificationservice.integration.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics = "notification", groupId = "g1")
	public void handleNotification(OrderPlacedEvent orderPlacedEvent){
		log.info("Received notification for Order - {}", orderPlacedEvent.orderNumber());
	}
}
