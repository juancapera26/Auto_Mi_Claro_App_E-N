Feature: ingreso a la super app

  @loginEYN_01
    Scenario: login exitoso con correo electrónico
    Given el usuario abre la super app
    When el usuario realiza el ingreso
    Then verifica version de la super app

  @SA002
  Scenario: login exitoso con cédula
    Given el usuario abre la super app
    When el usuario realiza el ingreso con cedula
    Then verifica version de la super app
