package br.com.acqio.transaction.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.acqio.transaction.model.enums.CardApplication;
import br.com.acqio.transaction.model.enums.PaymentStatus;

@Entity
public class Payload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate date;
	private LocalDateTime time;
	private BigDecimal value;

	@Enumerated(EnumType.STRING)
	private CardApplication cardApplication;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	public Payload() {
		super();
	}

	public Payload(LocalDate date, LocalDateTime time, BigDecimal value, CardApplication cardApplication,
			PaymentStatus status) {
		super();
		this.date = date;
		this.time = time;
		this.value = value;
		this.cardApplication = cardApplication;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
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

}
