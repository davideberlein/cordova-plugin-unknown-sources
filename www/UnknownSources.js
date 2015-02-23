// Returns a jQuery or AngularJS deferred object, or pass a success and fail callbacks if you don't want to use jQuery or AngularJS
var UnknownSources = {
    isUnknownSourcesActivated: function (success, fail) {
        var dfr;
        if ((typeof success) === 'undefined') {
            if (window.angular) {
                dfr = $q.defer();
            } else if (window.jQuery) {
                dfr = jQuery.Deferred();
            } else {
                return console.error('UnknownSourcesPlugin either needs a success callback, or jQuery/AngularJS defined for using promises');
            }
            success = dfr.resolve;
            fail = dfr.reject;
        }
        // 5th param is NOT optional. must be at least empty array
        cordova.exec(success, fail, "UnknownSources", "isUnknownSourcesActivated", []);
        return dfr;
    },
    goToUnknownSourcesSettings: function (success, fail) {
        var dfr;
        if ((typeof success) === 'undefined') {
            if (window.angular) {
                dfr = $q.defer();
            } else if (window.jQuery) {
                dfr = jQuery.Deferred();
            } else {
                return console.error('UnknownSourcesPlugin either needs a success callback, or jQuery/AngularJS defined for using promises');
            }
            success = dfr.resolve;
            fail = dfr.reject;
        }
        // 5th param is NOT optional. must be at least empty array
        cordova.exec(success, fail, "UnknownSources", "goToUnknownSourcesSettings", []);
        return dfr;
    }
};

module.exports = UnknownSources;
