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

<a name="0.1.0"></a>
# [0.1.0](https://github.com/shardis/shardis/compare/v0.0.9...v0.1.0) (2017-05-07)


### Features

* **core:** move angular app to separate library ([1bf8233](https://github.com/shardis/shardis/commit/1bf8233))
* **core:** replace npm by yarn ([43391ba](https://github.com/shardis/shardis/commit/43391ba))
* **core:** switch to multi project architecture ([66bc63a](https://github.com/shardis/shardis/commit/66bc63a))
* **core:** update kotlin to 1.1.2 ([83c2d2b](https://github.com/shardis/shardis/commit/83c2d2b))
* **frontend:** add fix option to linter ([43fc654](https://github.com/shardis/shardis/commit/43fc654))
* **frontend:** update angular to 4.1.0 ([32ceb7e](https://github.com/shardis/shardis/commit/32ceb7e))
* **frontend:** update angular to 4.1.1 ([1314634](https://github.com/shardis/shardis/commit/1314634))
* **frontend:** update angular-cli to 1.0.1 ([9b6045b](https://github.com/shardis/shardis/commit/9b6045b))
* **frontend:** update angular-cli to 1.0.2 ([54f4553](https://github.com/shardis/shardis/commit/54f4553))
* **frontend:** update clarity to 0.9.2 ([32272e3](https://github.com/shardis/shardis/commit/32272e3))
* **frontend:** update clarity to 0.9.3 ([0e67627](https://github.com/shardis/shardis/commit/0e67627))
* **frontend:** update codelyzer to 3.0.0 and tslint to 5.1.0 ([9b84037](https://github.com/shardis/shardis/commit/9b84037))
* **frontend:** update compodoc to 1.0.0-beta.8 ([7f8ffe7](https://github.com/shardis/shardis/commit/7f8ffe7))
* **frontend:** update ng2-webstorage to ngx-webstorage ([31d2ae3](https://github.com/shardis/shardis/commit/31d2ae3))
* **frontend:** update node to 7.10.0 ([e1c8a81](https://github.com/shardis/shardis/commit/e1c8a81))
* **frontend:** update typescript to 2.3.1 ([f162c59](https://github.com/shardis/shardis/commit/f162c59))
* **frontend:** update typescript to 2.3.2 ([ed790bd](https://github.com/shardis/shardis/commit/ed790bd))
* **frontend:** update yarn to 0.23.3 ([97b5140](https://github.com/shardis/shardis/commit/97b5140))
* **frontend:** update yarn to 0.23.4 ([fd07ef6](https://github.com/shardis/shardis/commit/fd07ef6))

[CHANGELOG.md](CHANGELOG.md)
