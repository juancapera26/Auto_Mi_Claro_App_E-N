Feature: Ingresar al módulo de Atención al cliente y soporte


  @ACVT001
  Scenario: Ingresar al Atencion al cliente Visitas ténicas
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And SELECCIONA LA OPCION VISITAS TECNICAS

  @ACVT002
  Scenario: Ingresar al Atencion al cliente estado servicio ténicas
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And SELECCIONA LA OPCION ESTADO SERVICIOS TECNICOS

  @ACVT003
  Scenario: Ingresar al Atencion al cliente Consultar pqr
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A LA OPCION CONSULTAR PQR
    And VALIDA VERSION DE MINIPROGRAMA CONSULTAR PQR
    And VER DETALLE CONSULTA PQR



