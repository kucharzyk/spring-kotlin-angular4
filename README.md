# Shardis Project

[![GitHub release](https://img.shields.io/github/release/shardis/shardis.svg)]()
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

## Npm tasks

### Angular development server with proxy to spring application
```
./npmw run server 
```

### Angular unit tests (chrome)
```
./npmw run test:live 
```

### Angular unit tests (chrome - single run)
```
./npmw run test
```

### Build documentation
```
./npmw run docs
```

## Changelog

<a name="0.0.8"></a>
## [0.0.8](https://github.com/shardis/shardis/compare/v0.0.7...v0.0.8) (2017-04-20)


### Features

* **axon:** add axon framework dependency ([d055b43](https://github.com/shardis/shardis/commit/d055b43))
* **axon:** add axon tables to generated schema.sql ([2a5f298](https://github.com/shardis/shardis/commit/2a5f298))
* **frontend:** downgrade zone.js version to 0.7.2 ([101b541](https://github.com/shardis/shardis/commit/101b541))
* **frontend:** update angular-cli to 1.0.0 ([4c4bb85](https://github.com/shardis/shardis/commit/4c4bb85))
* **frontend:** update angular-cli to 1.0.0-rc.4 ([fc3316a](https://github.com/shardis/shardis/commit/fc3316a))
* **frontend:** update clarity to 0.8.12 ([d282bf3](https://github.com/shardis/shardis/commit/d282bf3))
* **frontend:** update karma-coverage-istanbul-reporter to 1.0.0 ([e986341](https://github.com/shardis/shardis/commit/e986341))
* **frontend:** update ngrx effects to 2.0.2 ([145483d](https://github.com/shardis/shardis/commit/145483d))
* **frontend:** update ngrx store-devtools to 3.2.4 ([4097a76](https://github.com/shardis/shardis/commit/4097a76))
* **frontend:** update node to 7.7.4 ([cf49980](https://github.com/shardis/shardis/commit/cf49980))
* **frontend:** update ts-node to 3.0.0 ([afe746d](https://github.com/shardis/shardis/commit/afe746d))
* **frontend:** update ts-node to 3.0.2 ([566d4be](https://github.com/shardis/shardis/commit/566d4be))


[CHANGELOG.md](CHANGELOG.md)
