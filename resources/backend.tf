terraform {
  backend "gcs" {
    bucket = "gcp-terraform-k8s"
    prefix = "pipeline1"
  }
}