//
//  ContentView.swift
//  Picsum
//
//  Created by Omico on 9/17/24.
//

import PicsumKt
import SwiftUI
import UIKit

struct ContentView: View {
    var body: some View {
        ComposeView()
            .ignoresSafeArea()
    }
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        PicsumKt.MainViewController() 
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

#Preview {
    ContentView()
}
