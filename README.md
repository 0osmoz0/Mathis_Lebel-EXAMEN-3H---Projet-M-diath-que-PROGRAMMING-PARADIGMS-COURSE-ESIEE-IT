# EXAMEN-3H---Projet-M-diath-que-PROGRAMMING-PARADIGMS-COURSE-ESIEE-IT

## Architecture

Cette application suit une architecture **DDD (Domain-Driven Design) pragmatique** avec une séparation stricte des responsabilités, sans framework ni magie.

### Vision globale

```
CLI ──▶ Service ──▶ Repositories ──▶ Domain
           ▲
         Tests
```

**Principe directeur :**
- **Le domaine ne dépend de rien** (couche la plus pure)
- **Les règles métier vivent dans le service**, pas dans la CLI
- **Les invariants sont garantis** par les constructeurs et méthodes du domaine

### Organisation des packages

```
exam/
├── domain/          # Cœur métier PUR (aucune dépendance externe)
│   ├── oeuvre/
│   │   ├── Oeuvre.java
│   │   ├── Livre.java
│   │   └── Dvd.java
│   ├── membre/
│   │   ├── Membre.java
│   │   └── StatutMembre.java
│   └── emprunt/
│       └── Emprunt.java
│
├── repo/            # Contrats (interfaces) - DIP (Dependency Inversion Principle)
│   ├── OeuvreRepository.java
│   ├── MembreRepository.java
│   └── EmpruntRepository.java
│
├── repo.impl/       # Implémentations en mémoire
│   ├── InMemoryOeuvreRepository.java
│   ├── InMemoryMembreRepository.java
│   └── InMemoryEmpruntRepository.java
│
├── service/         # Règles métier et orchestration
│   ├── MediathequeService.java
│   └── EmpruntPolicy.java
│
├── cli/             # I/O seulement (couche mince)
│   └── MediathequeCLI.java
│
└── util/            # Utilitaires (optionnel)
    └── IdGenerator.java
```

### Principes architecturaux

#### 1. **Domain Layer** (`domain/`)
- **Rôle** : Entités métier pures, sans dépendances externes
- **Responsabilités** :
  - Encapsulation des données
  - Validation des invariants métier
  - Logique métier intrinsèque aux entités
- **Règle** : Aucune dépendance vers les autres couches

#### 2. **Repository Layer** (`repo/` et `repo.impl/`)
- **`repo/`** : Interfaces définissant les contrats de persistance (DIP)
- **`repo.impl/`** : Implémentations concrètes (ici en mémoire)
- **Avantage** : Facilement remplaçable par une implémentation base de données sans modifier le service

#### 3. **Service Layer** (`service/`)
- **Rôle** : Orchestration et règles métier complexes
- **Responsabilités** :
  - Coordination entre repositories
  - Application des politiques métier (ex: `EmpruntPolicy`)
  - Validation des règles transversales
- **Testabilité** : Facilement testable via injection des repositories

#### 4. **CLI Layer** (`cli/`)
- **Rôle** : Interface utilisateur minimale
- **Responsabilités** :
  - Lecture des entrées utilisateur
  - Affichage des résultats
  - Délégation au service pour toute logique métier
- **Règle** : Aucune logique métier dans la CLI

### Encapsulation et invariants

- Les **constructeurs** garantissent la création d'objets valides
- Les **méthodes du domaine** préservent les invariants
- Les **règles métier** sont explicites et testables

### Avantages de cette architecture

1. **Testabilité** : Chaque couche peut être testée indépendamment
2. **Maintenabilité** : Séparation claire des responsabilités
3. **Évolutivité** : Facile d'ajouter de nouvelles fonctionnalités
4. **Respect des principes SOLID** :
   - **S**ingle Responsibility : Chaque classe a une responsabilité unique
   - **O**pen/Closed : Extension via interfaces
   - **L**iskov Substitution : Polymorphisme respecté
   - **I**nterface Segregation : Interfaces ciblées
   - **D**ependency Inversion : Dépendances vers les abstractions

### Utilisation

1. Le **Service** orchestre les opérations métier
2. Les **Repositories** gèrent la persistance (ici en mémoire)
3. Le **Domain** contient la logique métier pure
4. La **CLI** interagit avec l'utilisateur

Cette architecture garantit un code **propre**, **testable** et **maintenable**.