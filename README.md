
# react-native-permission

## Getting started

`$ npm install react-native-permission --save`

### Mostly automatic installation

`$ react-native link react-native-permission`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.yanmay.permission.RNPermissionPackage;` to the imports at the top of the file
  - Add `new RNPermissionPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-permission'
  	project(':react-native-permission').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-permission/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-permission')
  	```


## Usage
```javascript
import RNPermission from 'react-native-permission';

// TODO: What to do with the module?
RNPermission;
```
  
