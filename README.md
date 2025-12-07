# Architecture des Composants d'Entreprise - Travaux Pratiques

Ce dépôt contient l'ensemble des travaux pratiques (TP) réalisés dans le cadre du module **Architecture des Composants d'Entreprise**. L'objectif est de maîtriser le développement backend moderne avec l'écosystème **Spring Framework**.

## 👤 Auteur
**Nom :** Amine içame / salma Benomar 
**Niveau :** 5 eme annee informatqie et reseaux filiere MIAGE  
**École :** EMSI

---

## 🛠 Technologies utilisées
*   **Langage :** Java 17
*   **Frameworks :** Spring Boot 3, Spring Framework 6
*   **Build Tool :** Maven
*   **Base de données :** H2 Database (In-memory)
*   **Tests :** JUnit 5, Mockito
*   **Outils :** Postman, GraphiQL, Swagger UI

---

## 📂 Structure du Dépôt

Le projet est divisé en 4 parties distinctes, chacune abordant un concept clé de l'architecture logicielle :

### 1️⃣ TP 1 : Inversion de Contrôle (IOC) & Injection de Dépendances
*   **Dossier :** `TPIOC`
*   **Description :** Compréhension du couplage faible.
*   **Concepts clés :**
    *   Implémentation du pattern IOC.
    *   Injection par Modificateur (Setter), Constructeur et Interface.
    *   Utilisation des annotations `@Autowired`, `@Component`, `@Service`, `@Repository`.
    *   Configuration via `@Configuration` et `@Bean`.

### 2️⃣ TP 2 : Architecture REST avec Spring Boot
*   **Dossier :** `TPREST`
*   **Description :** Développement d'une API RESTful complète pour la gestion d'articles.
*   **Concepts clés :**
    *   Contrôleurs REST (`@RestController`, `@GetMapping`, etc.).
    *   Pattern DTO (Data Transfer Object) et Mapping.
    *   Validation des données (`@Valid`).
    *   Gestion centralisée des exceptions (`@ControllerAdvice`).
    *   Négociation de contenu (JSON/XML).

### 3️⃣ TP 3 : Spring Data REST & HATEOAS
*   **Dossier :** `TPDataRest`
*   **Description :** Génération automatique d'API REST à partir des interfaces Repository.
*   **Concepts clés :**
    *   Exposition des entités via `@RepositoryRestResource`.
    *   Projections pour personnaliser les données JSON.
    *   Documentation API avec **OpenAPI (Swagger)**.
    *   Pagination et Tri.

### 4️⃣ TP 4 : API GraphQL
*   **Dossier :** `BANK_SERVICE_graphql`
*   **Description :** Mise en place d'une API flexible permettant au client de demander des données spécifiques.
*   **Concepts clés :**
    *   Définition de Schémas GraphQL (`.graphqls`).
    *   Implémentation de `Query` (Lecture) et `Mutation` (Écriture).
    *   Utilisation de l'interface **GraphiQL**.
    *   Gestion des relations complexes (Clients -> Comptes -> Transactions).

---

## 🚀 Comment lancer les projets

Chaque TP est un projet Maven indépendant.

1.  **Cloner le dépôt :**
    ```bash
    git clone https://github.com/ton-utilisateur/nom-du-repo.git
    ```

2.  **Lancer un TP (exemple pour le TP4) :**
    *   Ouvrir le dossier dans IntelliJ IDEA.
    *   Attendre l'indexation Maven.
    *   Exécuter la classe principale (ex: `BankServiceApplication`).

3.  **Accéder aux interfaces :**
    *   **API REST (TP2/TP3) :** `http://localhost:8080/api/articles` ou `http://localhost:8080/swagger-ui.html`
    *   **GraphQL (TP4) :** `http://localhost:8080/graphiql`
    *   **Console H2 :** `http://localhost:8080/h2`

---

## 📝 Rapport
Un rapport détaillé regroupant l'ensemble des étapes, captures d'écran et explications techniques est disponible dans ce dépôt (voir fichier PDF ou LaTeX).

