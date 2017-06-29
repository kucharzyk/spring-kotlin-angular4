# Shardis Project

[![GitHub release](https://img.shields.io/github/release/shardis/shardis.svg)](https://github.com/shardis/shardis/releases)
[![build status](https://img.shields.io/travis/shardis/shardis/master.svg)](https://travis-ci.org/shardis/shardis)
[![AppVeyor](https://img.shields.io/appveyor/ci/kucharzyk/shardis.svg)](https://ci.appveyor.com/project/kucharzyk/shardis)
[![codecov](https://img.shields.io/codecov/c/github/shardis/shardis/master.svg)](https://codecov.io/gh/shardis/shardis)
[![license](https://img.shields.io/github/license/shardis/shardis.svg)](https://github.com/shardis/shardis)


## Note

This project is still a work in progress

## Features

* kotlin and spring boot for backend
* angular with clarity for frontend
* aot support for angular
* gradle as build tool
* node and angular-cli integration via gradle plugin

## Prerequisites

* Java 8 is required
* Google Chrome is required for tests
* Gradle and Node.js and not required

## Gradle tasks

### Running Spring Boot webapp
```
./gradlew shardis-webapp:bootRun 
```

### Production build
```
./gradlew build 
```

## Yarn tasks

### Angular development server with proxy to spring application
```
cd shardis-frontend
./yarnw run server 
```

### Angular unit tests (chrome)
```
cd shardis-frontend
./yarnw run test:live 
```

### Angular unit tests (chrome - single run)
```
cd shardis-frontend
./yarnw run test
```

### Build documentation
```
cd shardis-frontend
./yarnw run docs
```

## Changelog

<a name="0.1.3"></a>
## [0.1.3](https://github.com/shardis/shardis/compare/v0.1.2...v0.1.3) (2017-06-29)


### Features

* **core:** extract query domain to saparate library ([96d190d](https://github.com/shardis/shardis/commit/96d190d))
* **core:** remove hibernate-enverse ([28594cd](https://github.com/shardis/shardis/commit/28594cd))
* **core:** update kotlin to 1.1.2-5 ([7fd5233](https://github.com/shardis/shardis/commit/7fd5233))
* **core:** update kotlin to 1.1.3 ([5568b1d](https://github.com/shardis/shardis/commit/5568b1d))
* **core:** update spring boot to 2.0.0.M2 ([35dc176](https://github.com/shardis/shardis/commit/35dc176))
* **frontend:** update angular to 4.2.4 ([6d946d2](https://github.com/shardis/shardis/commit/6d946d2))
* **frontend:** update angular-cli to 1.1.3 ([926e4a0](https://github.com/shardis/shardis/commit/926e4a0))
* **frontend:** update clarity to 0.10.0-alpha ([2fe21a2](https://github.com/shardis/shardis/commit/2fe21a2))
* **frontend:** update clarity to 0.10.0-alpha.2 ([7d4f5c3](https://github.com/shardis/shardis/commit/7d4f5c3))
* **frontend:** update node to 8.1.3 ([f09f5df](https://github.com/shardis/shardis/commit/f09f5df))
* **frontend:** update typescript to 2.4.1 ([e8c0e36](https://github.com/shardis/shardis/commit/e8c0e36))
* **frontend:** update yarn to 0.24.6 ([d79c6ee](https://github.com/shardis/shardis/commit/d79c6ee))


### Reverts

* feat(frontend): update typescript to 2.4.1 ([76b3f9a](https://github.com/shardis/shardis/commit/76b3f9a))


[CHANGELOG.md](CHANGELOG.md)
