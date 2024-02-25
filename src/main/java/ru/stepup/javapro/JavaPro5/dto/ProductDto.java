package ru.stepup.javapro.JavaPro5.dto;

public class ProductDto {
    private Long id;
    private String accountNumber;
    private Double balance;
    private Integer type;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ProductDto(Long id, String accountNumber, Double balance, Integer type, Long userId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}