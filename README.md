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

<a name="0.1.2"></a>
## [0.1.2](https://github.com/shardis/shardis/compare/v0.1.1...v0.1.2) (2017-06-17)


### Features

* **axon:** update axon framework to 3.0.5 ([c4ec75b](https://github.com/shardis/shardis/commit/c4ec75b))
* **core:** update gradle dependency management plugin to 1.0.3.RELEASE ([1265775](https://github.com/shardis/shardis/commit/1265775))
* **core:** update gradle node plugin to 1.2.0 ([0181280](https://github.com/shardis/shardis/commit/0181280))
* **core:** update gradle to 4.0 ([5bbcdf8](https://github.com/shardis/shardis/commit/5bbcdf8))
* **core:** update spring-boot to 1.5.4.RELEASE ([1780e5e](https://github.com/shardis/shardis/commit/1780e5e))
* **frontend:** add intl and classlist.js polyfills ([18b1f67](https://github.com/shardis/shardis/commit/18b1f67))
* **frontend:** add some strict typescript options ([43fc837](https://github.com/shardis/shardis/commit/43fc837))
* **frontend:** enable strict null check ([8a3a069](https://github.com/shardis/shardis/commit/8a3a069))
* **frontend:** package.json cleanup ([0da9361](https://github.com/shardis/shardis/commit/0da9361))
* **frontend:** update angular to 4.2.2 ([74010af](https://github.com/shardis/shardis/commit/74010af))
* **frontend:** update angular to 4.2.3 ([d5cdd28](https://github.com/shardis/shardis/commit/d5cdd28))
* **frontend:** update angular-cli to 1.1.1 ([83bf299](https://github.com/shardis/shardis/commit/83bf299))
* **frontend:** update angular-cli to 1.1.2 ([c9e6966](https://github.com/shardis/shardis/commit/c9e6966))
* **frontend:** update clarity to 0.9.8 ([c8e4791](https://github.com/shardis/shardis/commit/c8e4791))
* **frontend:** update clarity to 0.9.9 ([99009c8](https://github.com/shardis/shardis/commit/99009c8))
* **frontend:** update node to 8.0.0 ([9166afa](https://github.com/shardis/shardis/commit/9166afa))
* **frontend:** update node to 8.1.0 ([ec3fde7](https://github.com/shardis/shardis/commit/ec3fde7))
* **frontend:** update node to 8.1.2 ([f2bf23b](https://github.com/shardis/shardis/commit/f2bf23b))


[CHANGELOG.md](CHANGELOG.md)
