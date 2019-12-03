package br.com.acqio.transaction.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.acqio.transaction.model.Payload;
import br.com.acqio.transaction.model.enums.CardApplication;
import br.com.acqio.transaction.model.enums.PaymentStatus;
import br.com.acqio.transaction.repository.PayloadRepository;

public class UpdatePayloadForm {

	private Long id;
	private String date;
	private String time;
	private BigDecimal value;
	private CardApplication cardApplication;
	private PaymentStatus status;

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

	public void setStatus(PaymentStatus paymentStatus) {
		this.status = paymentStatus;
	}

	public Payload update(PayloadRepository payloadRepository) {
		Payload payload = payloadRepository.getOne(this.id);
		
		LocalDate dateF = LocalDate.parse(this.date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDateTime timeF = LocalDateTime.parse(this.date.concat(" " + this.time), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
			
		payload.setDate(dateF);
		payload.setTime(timeF);
		payload.setValue(this.value);
		payload.setCardApplication(this.cardApplication);
		payload.setStatus(this.status);
		return payload;
	}

}
