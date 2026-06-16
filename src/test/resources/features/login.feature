Feature: ingreso a la super app

  @loginE&N_01
    Scenario: login exitoso con correo electrónico
    Given el usuario abre la super app
    When el usuario realiza el ingreso
    Then verifica version de la super app

  @SA002
  Scenario: login exitoso con cédula
    Given el usuario abre la super app
    When el usuario realiza el ingreso con cedula
    Then verifica version de la super app


    ################################################################################################

  #Login

  @login_correo_01
  Scenario: login exitoso con correo electrónico
    Given el usuario abre la super app
    When el usuario realiza el ingreso con correo


  @login_documento_01
  Scenario: login exitoso con documento
    Given el usuario abre la super app
    When el usuario realiza el ingreso con documento


  @login_pin_01
  Scenario: login exitoso con pin
    Given el usuario abre la super app
    When el usuario realiza el ingreso con pin
