(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["app-main-apps-apps-module"],{

/***/ "./src/@persoinfo/event/EventManager.ts":
/*!**********************************************!*\
  !*** ./src/@persoinfo/event/EventManager.ts ***!
  \**********************************************/
/*! exports provided: EventManager */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EventManager", function() { return EventManager; });
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



/**
 * An utility class to manage RX events
 */
var EventManager = /** @class */ (function () {
    function EventManager() {
        var _this = this;
        this.observable = rxjs__WEBPACK_IMPORTED_MODULE_0__["Observable"].create(function (observer) {
            _this.observer = observer;
        }).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["share"])());
    }
    /**
     * Method to broadcast the event to observer
     */
    EventManager.prototype.broadcast = function (event) {
        if (this.observer != null) {
            this.observer.next(event);
        }
    };
    /**
     * Method to subscribe to an event with callback
     */
    EventManager.prototype.subscribe = function (eventName, callback) {
        return this.observable
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["filter"])(function (event) {
            return event.name === eventName;
        }))
            .subscribe(callback);
    };
    /**
     * Method to unsubscribe the subscription
     */
    EventManager.prototype.destroy = function (subscriber) {
        subscriber.unsubscribe();
    };
    EventManager = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [])
    ], EventManager);
    return EventManager;
}());



/***/ }),

/***/ "./src/app/main/apps/apps.module.ts":
/*!******************************************!*\
  !*** ./src/app/main/apps/apps.module.ts ***!
  \******************************************/
/*! exports provided: AppsModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppsModule", function() { return AppsModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _persoinfo_shared_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @persoinfo/shared.module */ "./src/@persoinfo/shared.module.ts");
/* harmony import */ var _persoinfo_services_alert_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @persoinfo/services/alert.service */ "./src/@persoinfo/services/alert.service.ts");
/* harmony import */ var _persoinfo_event_EventManager__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @persoinfo/event/EventManager */ "./src/@persoinfo/event/EventManager.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var routes = [
    {
        path: 'mail',
        loadChildren: './mail/mail.module#MailModule'
    },
    {
        path: 'chat',
        loadChildren: './chat/chat.module#ChatModule'
    },
    {
        path: 'calendar',
        loadChildren: './calendar/calendar.module#CalendarModule'
    },
    {
        path: 'todo',
        loadChildren: './todo/todo.module#TodoModule'
    },
    {
        path: 'file-manager',
        loadChildren: './file-manager/file-manager.module#FileManagerModule'
    },
    {
        path: 'contacts',
        loadChildren: './contacts/contacts.module#ContactsModule'
    },
    {
        path: 'scrumboard',
        loadChildren: './scrumboard/scrumboard.module#ScrumboardModule'
    }
];
var AppsModule = /** @class */ (function () {
    function AppsModule() {
    }
    AppsModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes),
                _persoinfo_shared_module__WEBPACK_IMPORTED_MODULE_2__["PersoInfoSharedModule"]
            ],
            providers: [
                _persoinfo_event_EventManager__WEBPACK_IMPORTED_MODULE_4__["EventManager"],
                _persoinfo_services_alert_service__WEBPACK_IMPORTED_MODULE_3__["PersoInfoAlertService"]
            ]
        })
    ], AppsModule);
    return AppsModule;
}());



/***/ })

}]);
//# sourceMappingURL=app-main-apps-apps-module.js.map