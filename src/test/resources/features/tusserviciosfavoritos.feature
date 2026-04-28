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

  @SF03
  Scenario: Ingresar a servicios favoritos y pagar factura pagos automaticos
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And VALIDA PAGOS AUTOMATICOS

  @SF04
  Scenario: Ingresar a servicios favoritos y pagar factura por correo
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And ENVIA FACTURA POR CORREO
