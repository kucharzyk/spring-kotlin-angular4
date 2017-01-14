# Shardis Project

[![build status](https://img.shields.io/travis/shardis/shardis/master.svg)](https://travis-ci.org/shardis/shardis)
[![AppVeyor](https://img.shields.io/appveyor/ci/kucharzyk/shardis.svg)](https://ci.appveyor.com/project/kucharzyk/shardis)
[![codecov](https://img.shields.io/codecov/c/github/shardis/shardis/master.svg)](https://codecov.io/gh/shardis/shardis)
[![dependencies](https://img.shields.io/david/shardis/shardis.svg)](https://david-dm.org/shardis/shardis)
[![dev dependencies](https://img.shields.io/david/dev/shardis/shardis.svg)](https://david-dm.org/shardis/shardis)
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
* Gradle and Node.js and not required

## Gradle tasks

### Running Spring Boot app
```
./gradlew bootRun 
```

### Production build
```
./gradlew build 
```

## Yarn tasks

### Angular development server with proxy to spring application
```
./yarnw run server 
```

### Angular unit tests (chrome)
```
./yarnw run test:live 
```

### Angular unit tests (chrome - single run)
```
./yarnw run test
```

### Angular unit tests (phantom - single run)
```
./yarnw run test:phantom
```

### Run compdoc
```
./yarnw run docs
```

## Changelog

<a name="0.0.2"></a>
## [0.0.2](https://github.com/shardis/shardis/compare/v0.0.1...v0.0.2) (2017-01-14)


### Bug Fixes

* **frontend:** disable gradle deamon ([96edf86](https://github.com/shardis/shardis/commit/96edf86))
* **frontend:** downgrade node to 6.9.3 due to issues on windows ([a211307](https://github.com/shardis/shardis/commit/a211307))
* **frontend:** re-enable gradle deamon ([21a6ebf](https://github.com/shardis/shardis/commit/21a6ebf))
* **frontend:** remove hmr code ([fab9344](https://github.com/shardis/shardis/commit/fab9344))
* **frontend:** update node back to 7.4.0 ([33d2387](https://github.com/shardis/shardis/commit/33d2387))
* **tests:** fix phantomjs timeout on window ([139b2ea](https://github.com/shardis/shardis/commit/139b2ea))
* **yarn:** fix yarnw unix wrapper after gradle node plugin update ([2231cad](https://github.com/shardis/shardis/commit/2231cad))
* **yarn:** fix yarnw windows wrapper after gradle node plugin update ([aaafc4d](https://github.com/shardis/shardis/commit/aaafc4d))


### Features

* **core:** add custom ResourceResolver instead of using ErrorPageRegistrar ([9b0a49b](https://github.com/shardis/shardis/commit/9b0a49b))
* **core:** add evers configuration for auditing ([6368a35](https://github.com/shardis/shardis/commit/6368a35))
* **core:** add hibernate-jpamodelgen to generate jpa metamodel ([5ac232f](https://github.com/shardis/shardis/commit/5ac232f))
* **core:** add jwt security (backend) ([040ff28](https://github.com/shardis/shardis/commit/040ff28))
* **core:** add spring-data-jpa, spring security, auto sql schema generation ([1290bd8](https://github.com/shardis/shardis/commit/1290bd8))
* **core:** passing project version from gradle to app ([b5a351d](https://github.com/shardis/shardis/commit/b5a351d))
* **core:** undertow as default container ([4aaa830](https://github.com/shardis/shardis/commit/4aaa830))
* **core:** upgrade gradle wrapper to 3.3 ([55cfb90](https://github.com/shardis/shardis/commit/55cfb90))
* **frontend:** add [@ngrx](https://github.com/ngrx)/store with sample counter component ([d5ec07a](https://github.com/shardis/shardis/commit/d5ec07a))
* **frontend:** add extract-css flag to build scripts ([32be8e0](https://github.com/shardis/shardis/commit/32be8e0))
* **frontend:** update angular-cli to 1.0.0-beta25.5 ([341bb9b](https://github.com/shardis/shardis/commit/341bb9b))
* **test:** ads AppVeyor tests on windows ([85418a4](https://github.com/shardis/shardis/commit/85418a4))



[CHANGELOG.md](CHANGELOG.md)
