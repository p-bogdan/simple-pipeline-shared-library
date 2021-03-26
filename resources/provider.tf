
provider "google" {
  project = "lab-project-282605"
  region  = "us-central1"
}

terraform {
  required_providers {
    mycloud = {
      source  = "hashicorp/google"
      version = "~> 3.60.0"
    }
  }
}
