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

<a name="0.0.7"></a>
## [0.0.7](https://github.com/shardis/shardis/compare/v0.0.6...v0.0.7) (2017-03-19)


### Features

* **core:** replace kotlin-stdlib with kotlin-stdlib-jre8 ([05dec83](https://github.com/shardis/shardis/commit/05dec83))
* **core:** update dependency-management-plugin to 1.0.1.RELEASE ([fb5ffe7](https://github.com/shardis/shardis/commit/fb5ffe7))
* **core:** update gradle to 3.4.1 ([145e416](https://github.com/shardis/shardis/commit/145e416))
* **core:** update kotlin to 1.1.0 ([2f234ca](https://github.com/shardis/shardis/commit/2f234ca))
* **core:** update kotlin to 1.1.1 ([68791c0](https://github.com/shardis/shardis/commit/68791c0))
* **core:** update spring boot to 1.5.2.RELEASE ([a2f2f05](https://github.com/shardis/shardis/commit/a2f2f05))
* **frontend:** update [@ngrx](https://github.com/ngrx)/effects to 2.0.1 ([75d64e7](https://github.com/shardis/shardis/commit/75d64e7))
* **frontend:** update angular to 2.4.10 ([64bb02c](https://github.com/shardis/shardis/commit/64bb02c))
* **frontend:** update angular to 2.4.9 ([2ffa2a7](https://github.com/shardis/shardis/commit/2ffa2a7))
* **frontend:** update angular-cli to 1.0.0-rc.2 ([7060c40](https://github.com/shardis/shardis/commit/7060c40))
* **frontend:** update clarity to 0.8.10 ([0161bef](https://github.com/shardis/shardis/commit/0161bef))
* **frontend:** update clarity to 0.8.11 ([7eda324](https://github.com/shardis/shardis/commit/7eda324))
* **frontend:** update conventional-changelog-cli to 1.3.1 ([99a29e4](https://github.com/shardis/shardis/commit/99a29e4))
* **frontend:** update ng2-webstorage to 1.5.1 ([dfca821](https://github.com/shardis/shardis/commit/dfca821))
* **frontend:** update node to 7.7.0 ([76c1662](https://github.com/shardis/shardis/commit/76c1662))
* **frontend:** update node to 7.7.1 ([2f85cd7](https://github.com/shardis/shardis/commit/2f85cd7))
* **frontend:** update node to 7.7.2 and npm to 4.4.1 ([7f197b5](https://github.com/shardis/shardis/commit/7f197b5))
* **frontend:** update node to 7.7.3 ([b09d30f](https://github.com/shardis/shardis/commit/b09d30f))

[CHANGELOG.md](CHANGELOG.md)
