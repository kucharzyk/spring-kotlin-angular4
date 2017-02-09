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

<a name="0.0.4"></a>
## [0.0.4](https://github.com/shardis/shardis/compare/v0.0.3...v0.0.4) (2017-02-09)


### Bug Fixes

* **frontend:** temporary use lazy loaded routes with aot (fixes [#1](https://github.com/shardis/shardis/issues/1)) ([a24eed8](https://github.com/shardis/shardis/commit/a24eed8))


### Features

* **ci:** use chrome instead of phantomjs for ci testing ([548a0e7](https://github.com/shardis/shardis/commit/548a0e7))
* **core:** add simple jwt authentication ([787dcef](https://github.com/shardis/shardis/commit/787dcef))
* **core:** add spring dependency management plugin for gradle ([3433e96](https://github.com/shardis/shardis/commit/3433e96))
* **core:** specify kotlin api version ([089ebcb](https://github.com/shardis/shardis/commit/089ebcb))
* **core:** update angular to 2.4.6 ([0e2d996](https://github.com/shardis/shardis/commit/0e2d996))
* **core:** update angular to 2.4.7 and clarity to 0.8.6 ([da070bc](https://github.com/shardis/shardis/commit/da070bc))
* **core:** use gradle script kotlin and kotlin 1.1.0-beta-38 ([8eaf9f1](https://github.com/shardis/shardis/commit/8eaf9f1))
* **frontend:** add store for authorization (basic stub) ([df83f9a](https://github.com/shardis/shardis/commit/df83f9a))
* **frontend:** login form (work in progress) ([c5f9418](https://github.com/shardis/shardis/commit/c5f9418))
* **frontend:** update angular-cli to 1.0.0-beta.30 ([ea88357](https://github.com/shardis/shardis/commit/ea88357))
* **tests:** remove phantomjs ([2565d5a](https://github.com/shardis/shardis/commit/2565d5a))



[CHANGELOG.md](CHANGELOG.md)
