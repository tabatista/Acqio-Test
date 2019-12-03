package br.com.acqio.transaction.controller.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import br.com.acqio.transaction.model.Payload;
import br.com.acqio.transaction.model.enums.CardApplication;
import br.com.acqio.transaction.model.enums.PaymentStatus;

public class PayloadDTO {

	private Long id;
	private String date;
	private String time;
	private BigDecimal value;
	private CardApplication cardApplication;
	private PaymentStatus status;

	public PayloadDTO(Payload payload) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		this.id = payload.getId();
		this.date = formatter.format(payload.getDate());

		formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		this.time = formatter.format(payload.getTime());
		this.value = payload.getValue();
		this.cardApplication = payload.getCardApplication();
		this.status = payload.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public CardApplication getCardApplication() {
		return cardApplication;
	}

	public void setCardApplication(CardApplication cardApplication) {
		this.cardApplication = cardApplication;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public static List<PayloadDTO> convert(List<Payload> payloads) {
		return payloads.stream().map(PayloadDTO::new).collect(Collectors.toList());
	}

}
