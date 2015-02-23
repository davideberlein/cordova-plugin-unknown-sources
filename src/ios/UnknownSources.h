#import <Cordova/CDVPlugin.h>

@interface UnknownSources : CDVPlugin

- (void)isUnknownSourcesActivated:(CDVInvokedUrlCommand*)command;
- (void)goToUnknownSourcesSettings:(CDVInvokedUrlCommand*)command;

@end
