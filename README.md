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

### Running Spring Boot app
```
./gradlew shardis-web:bootRun 
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

<a name="0.1.1"></a>
## [0.1.1](https://github.com/shardis/shardis/compare/v0.1.0...v0.1.1) (2017-06-01)


### Features

* **frontend:** update angular to 4.1.2 ([12218d4](https://github.com/shardis/shardis/commit/12218d4))
* **frontend:** update angular to 4.1.3 ([5550830](https://github.com/shardis/shardis/commit/5550830))
* **frontend:** update angular-cli to 1.0.3 ([d423376](https://github.com/shardis/shardis/commit/d423376))
* **frontend:** update angular-cli to 1.0.4 ([856cb58](https://github.com/shardis/shardis/commit/856cb58))
* **frontend:** update angular-cli to 1.0.6 ([430a18e](https://github.com/shardis/shardis/commit/430a18e))
* **frontend:** update angular-cli to 1.1.0 ([603e011](https://github.com/shardis/shardis/commit/603e011))
* **frontend:** update clarity to 0.9.4-patch ([cc0a2ed](https://github.com/shardis/shardis/commit/cc0a2ed))
* **frontend:** update clarity to 0.9.5 ([d9dade4](https://github.com/shardis/shardis/commit/d9dade4))
* **frontend:** update clarity to 0.9.6 ([d7c9a29](https://github.com/shardis/shardis/commit/d7c9a29))
* **frontend:** update clarity to 0.9.7 ([3ad78da](https://github.com/shardis/shardis/commit/3ad78da))
* **frontend:** update ngrx-store-localstorage to 0.1.8 ([05ea2cd](https://github.com/shardis/shardis/commit/05ea2cd))
* **frontend:** update typescript to 2.3.3 ([dbf4465](https://github.com/shardis/shardis/commit/dbf4465))
* **frontend:** update typescript to 2.3.4 ([751120b](https://github.com/shardis/shardis/commit/751120b))
* **frontend:** update yarn to 0.24.4 ([3d3f7e6](https://github.com/shardis/shardis/commit/3d3f7e6))
* **frontend:** update yarn to 0.24.5 ([c658032](https://github.com/shardis/shardis/commit/c658032))


[CHANGELOG.md](CHANGELOG.md)
