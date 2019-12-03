package br.com.acqio.transaction.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.acqio.transaction.model.Payload;
import br.com.acqio.transaction.model.enums.CardApplication;
import br.com.acqio.transaction.model.enums.PaymentStatus;

public class PayloadForm {

	private String date;
	private String time;
	private BigDecimal value;
	private CardApplication cardApplication;
	private PaymentStatus status;

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

	public Payload convert() {
		LocalDate dateF = LocalDate.parse(this.date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDateTime timeF = LocalDateTime.parse(this.date.concat(" " + this.time), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		return new Payload(dateF, timeF, this.value, this.cardApplication, this.status);
	}

}
