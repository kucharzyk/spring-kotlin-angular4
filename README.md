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

<a name="0.0.3"></a>
## [0.0.3](https://github.com/shardis/shardis/compare/v0.0.2...v0.0.3) (2017-02-02)


### Bug Fixes

* **phantomjs:** set DEFAULT_TIMEOUT_INTERVAL for jasmine ([ce30d62](https://github.com/shardis/shardis/commit/ce30d62))


### Features

* **core:** update spring boot to 1.4.4.RELEASE ([8018c93](https://github.com/shardis/shardis/commit/8018c93))
* **core:** update spring boot to 1.5.1.RELEASE ([0b13c03](https://github.com/shardis/shardis/commit/0b13c03))
* **frontend:** add auth module and refacor app structure ([c3c23d5](https://github.com/shardis/shardis/commit/c3c23d5))
* **frontend:** add clarity login page component ([b34e635](https://github.com/shardis/shardis/commit/b34e635))
* **frontend:** connect [@ngrx](https://github.com/ngrx)/router-store to application ([dfeb3c9](https://github.com/shardis/shardis/commit/dfeb3c9))
* **frontend:** turn on noImplicitAny option ([4ecab3f](https://github.com/shardis/shardis/commit/4ecab3f))
* **frontend:** update angular to 2.4.4. ([fd44edb](https://github.com/shardis/shardis/commit/fd44edb))
* **frontend:** update angular to 2.4.5 ([af3ef09](https://github.com/shardis/shardis/commit/af3ef09))
* **frontend:** update angular-cli to 1.0.0-beta26 ([f69a203](https://github.com/shardis/shardis/commit/f69a203))
* **frontend:** update node to 7.5.0 ([198b281](https://github.com/shardis/shardis/commit/198b281))



[CHANGELOG.md](CHANGELOG.md)
