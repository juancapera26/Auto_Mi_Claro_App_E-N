Feature: Tus servicios favoritos


  @SF01
  Scenario: Ingresar a servicios favoritos y pagar factura
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA

  @SF02
  Scenario: Ingresar a servicios favoritos y pagar factura descarga tu factura
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And DESCARGAR FACTURA

  @SF02
  Scenario: Ingresar a servicios favoritos y pagar factura descarga tu factura
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And DESCARGAR FACTURA
