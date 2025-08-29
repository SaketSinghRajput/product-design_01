// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyDIMfTf9r9W-FCg1JDwEOA_zaLmYhKOq_E",
  authDomain: "memories-maker.firebaseapp.com",
  databaseURL: "https://memories-maker-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "memories-maker",
  storageBucket: "memories-maker.firebasestorage.app",
  messagingSenderId: "1097235557777",
  appId: "1:1097235557777:web:5e172e9d6e24c890c8fe30",
  measurementId: "G-KFR0RM6S5G"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);