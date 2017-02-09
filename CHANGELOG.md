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



<a name="0.0.1"></a>
## [0.0.1](https://github.com/shardis/shardis/compare/46c7d6a...v0.0.1) (2017-01-03)


### Features

* **core:** add gradle kotlin plugin for jpa and spring ([4f817cf](https://github.com/shardis/shardis/commit/4f817cf))
* **core:** add node.js and yarn integration ([2212540](https://github.com/shardis/shardis/commit/2212540))
* **core:** add travis and codecov integration ([4c53060](https://github.com/shardis/shardis/commit/4c53060))
* **core:** rewrite gradle build script in kotlin ([46c7d6a](https://github.com/shardis/shardis/commit/46c7d6a))
* **core:** spring configuration properties support via kapt and spring-boot-configuration-processor ([6a9e83f](https://github.com/shardis/shardis/commit/6a9e83f))
* **core:** switch back to groovy gradle script ([5169829](https://github.com/shardis/shardis/commit/5169829))
* **frontend:** add angular-cli integration ([073abdb](https://github.com/shardis/shardis/commit/073abdb))
* **frontend:** add hmr support to angular-cli ([a3a26fb](https://github.com/shardis/shardis/commit/a3a26fb))
* **frontend:** add vmware clarity library ([62e4e5b](https://github.com/shardis/shardis/commit/62e4e5b))



