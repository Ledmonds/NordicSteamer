const {
    src,
    dest,
    watch
} = require("gulp");
const less = require("gulp-less");
const postcss = require("gulp-postcss");
const prefix = require("autoprefixer");
const cssnano = require("cssnano");
const rename = require("gulp-rename");
const plumber = require("gulp-plumber");
const uglify = require("gulp-uglify");


function compileBackendStyling() {
    const plugins = [
        prefix({
            grid: 'autoplace'
        }),
        cssnano()
    ]

    return src("../src/less/backend/backend.less")
        .pipe(plumber())
        .pipe(less())
        .pipe(postcss(plugins))
        .pipe(rename({
            suffix: ".min"
        }))
        .pipe(dest("../css/"));
}

function compileFrontendStyling() {
    const plugins = [
        prefix({
            grid: 'autoplace'
        }),
        cssnano()
    ]

    return src("../src/less/frontend/frontend.less")
        .pipe(plumber())
        .pipe(less())
        .pipe(postcss(plugins))
        .pipe(rename({
            suffix: ".min"
        }))
        .pipe(dest("../css/"));
}

function minJs() {
    return src("../src/js/main-function.js")
        .pipe(plumber())
        .pipe(uglify())
        .pipe(rename({
            suffix: ".min"
        }))
        .pipe(dest("../js/"));
}

function watchFiles() {
    watch("../src/less/backend/**/*.less", {
        ignoreInitial: false
    }, compileBackendStyling);
    watch("../src/less/frontend/**/*.less", {
        ignoreInitial: false
    }, compileFrontendStyling);
    watch("../src/js/main-function.js", {
        ignoreInitial: false
    }, minJs);
}

exports.default = watchFiles;