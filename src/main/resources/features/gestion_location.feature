#Scénario 1 : Location réussie
Feature: Gestion des locations de véhicules
  Scenario: Un client loue une voiture disponible
    Given Une voiture "Toyota" "Corolla" immatriculée "AA-123-BB" avec un tarif de 30000 F / j
    And Un client "Mansour" "Diouf"
    When Le client loue la voiture pour 3 jours
    Then La voiture ne doit plus être disponible
    And Le coût total de la location doit être de 90000 F
#Scénario 2 : Tentative de double location
  Scenario: Louer une voiture déjà louée
    Given Une voiture "Peugeot" "208" immatriculée "CC-456-DD" avec un tarif de 25000 F / j
    And Un client "Aminata" "Fall"
    When Le client loue la voiture pour 2 jours
    And Un autre client "Ousmane" "Sow" tente de la louer pour 1 jour
    Then Une exception "Véhicule déjà loué" doit être levée
#Scénario 3 : Retour de véhicule
  Scenario: Un client retourne une voiture louée
    Given Une voiture "BMW" "X5" immatriculée "EE-789-FF" louée par "Fatou" "Ndoye"
    When Le client retourne la voiture
    Then La voiture doit être disponible à nouveau
#Scénario 4 : Réduction pour moto > 500 cm³
  Scenario: Louer une moto de grosse cylindrée avec réduction
    Given Une moto "Yamaha" "MT-07" immatriculée "GG-321-HH" avec un tarif de 15000 F/j et une cylindrée de 600 cm³
    And Un client "Alioune" "Dieng"
    When Le client loue la moto pour 5 jours
    Then Le coût total de la location doit être de 67500 F (réduction appliquée)