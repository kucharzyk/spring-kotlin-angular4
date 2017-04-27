# Shardis Project

[![GitHub release](https://img.shields.io/github/release/shardis/shardis.svg)](https://github.com/shardis/shardis/releases)
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
* Google Chrome is required for tests
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

### Build documentation
```
./yarnw run docs
```

## Changelog

<a name="0.0.9"></a>
## [0.0.9](https://github.com/shardis/shardis/compare/v0.0.8...v0.0.9) (2017-04-22)


### Features

* **core:** update all libraries and switch to Angular 4.0.2 ([1938cb8](https://github.com/shardis/shardis/commit/1938cb8))
* **core:** update gradle to 3.5 ([75cf40b](https://github.com/shardis/shardis/commit/75cf40b))
* **core:** update spring boot to 1.5.3.RELEASE ([a772b5a](https://github.com/shardis/shardis/commit/a772b5a))
* **frontend:** update angular to 4.0.3 ([e81a6f9](https://github.com/shardis/shardis/commit/e81a6f9))
* **frontend:** update clarity to 0.9.1 ([6d70420](https://github.com/shardis/shardis/commit/6d70420))


[CHANGELOG.md](CHANGELOG.md)
