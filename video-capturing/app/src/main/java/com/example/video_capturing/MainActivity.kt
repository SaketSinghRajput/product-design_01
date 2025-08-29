package com.example.video_capturing

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.video_capturing.ui.theme.VideocapturingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // This is the main entry point for the activity.
        super.onCreate(savedInstanceState)
        // setContent is used to define the layout using Composable functions.
        setContent {
            VideocapturingTheme {
                // Surface is a container that uses the theme's background color.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // We call our main screen Composable here.
                    VideoCaptureScreen()
                }
            }
        }
    }
}

@Composable
fun VideoCaptureScreen() {
    // We need to request multiple permissions for video capture: Camera and Audio.
    val permissionsToRequest = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.RECORD_AUDIO
    )

    // rememberLauncherForActivityResult is a Composable way to handle activity results,
    // including permission requests.
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions ->
            // The result is a map of permission names to their granted status (Boolean).
            val allPermissionsGranted = permissions.values.all { it }
            if (allPermissionsGranted) {
                // All permissions were granted by the user.
                Log.d("PermissionCheck", "All permissions granted.")
                // Now you can proceed with the video recording logic.
            } else {
                // At least one permission was denied.
                Log.d("PermissionCheck", "One or more permissions were denied.")
                // It's good practice to show a message to the user explaining
                // why the permissions are needed for the feature to work.
            }
        }
    )

    // This is the main UI layout for the screen.
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // A simple text label to inform the user.
        Text("Ready to capture a clip?")

        // A button that triggers the permission request when clicked.
        Button(onClick = {
            // Launch the permission request dialog.
            launcher.launch(permissionsToRequest)
        }) {
            Text("Start Auto-Capture")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VideoCaptureScreenPreview() {
    // This preview allows you to see the UI in Android Studio without running the app.
    VideocapturingTheme {
        VideoCaptureScreen()
    }
}
