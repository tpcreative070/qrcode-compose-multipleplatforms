import UIKit
import SwiftUI
import ComposeApp
import sharedKit

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}

struct ContentView: View {
      let phrases = Greeting().greets()

      var body: some View {

          ComposeView()

          // List(phrases, id: \.self) {
          //     Text($0)
          // }

      }
}



