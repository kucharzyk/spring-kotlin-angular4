# Shardis Project

[![build status](https://img.shields.io/travis/shardis/shardis/master.svg)](https://travis-ci.org/shardis/shardis)
[![AppVeyor](https://img.shields.io/appveyor/ci/kucharzyk/shardis.svg)](https://ci.appveyor.com/project/kucharzyk/shardis)
[![codecov](https://img.shields.io/codecov/c/github/shardis/shardis/master.svg)](https://codecov.io/gh/shardis/shardis)
[![Dependency Status](https://www.versioneye.com/user/projects/58aa8111b4d2a20036950e02/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/58aa8111b4d2a20036950e02)
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

<a name="0.0.5"></a>
## [0.0.5](https://github.com/shardis/shardis/compare/v0.0.4...v0.0.5) (2017-02-17)


### Bug Fixes

* **"scripts":** fix condition in yarnw script ([b4f398a](https://github.com/shardis/shardis/commit/b4f398a))


### Features

* **core:** add querydsl ([0d26012](https://github.com/shardis/shardis/commit/0d26012))
* **core:** update angular-cli to 1.0.0-beta.31 and yarn to 0.20.0 ([3759a83](https://github.com/shardis/shardis/commit/3759a83))
* **core:** update angular-cli to 1.0.0-beta.32.3 ([ede3144](https://github.com/shardis/shardis/commit/ede3144))
* **core:** update kotlin to 1.1.0-rc-91 ([cae7e73](https://github.com/shardis/shardis/commit/cae7e73))
* **core:** update yarn to 0.20.3 ([490cc0f](https://github.com/shardis/shardis/commit/490cc0f))
* **frontend:** add ng2-webstorage package ([79b08b0](https://github.com/shardis/shardis/commit/79b08b0))
* **frontend:** store jwt in local storage ([761435b](https://github.com/shardis/shardis/commit/761435b))
* **frontend:** update clarity to 0.8.7 ([2967486](https://github.com/shardis/shardis/commit/2967486))
* **frontend:** use [@ngrx](https://github.com/ngrx)/effects for authentication ([a98aca1](https://github.com/shardis/shardis/commit/a98aca1))


[CHANGELOG.md](CHANGELOG.md)
