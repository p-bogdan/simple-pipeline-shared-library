resource "google_compute_instance" "default" {
  name         = "simple-pipeline-instance"
  machine_type = "n1-standard-1"
  zone         = "us-central1-a"
  project      = "lab-project-282605"
  #tags = ["foo", "bar"]

  boot_disk {
    initialize_params {
      image = "debian-cloud/debian-10"
    }
  }

  // Local SSD disk
  scratch_disk {
    interface = "SCSI"
  }

  network_interface {
    network = "default"

    access_config {
      // Ephemeral IP
    }
  }

  metadata = {
    foo = "bar"
  }

  #metadata_startup_script = "echo hi > /test.txt"

}

# resource "random_id" "instance_name_suffix" {
#   byte_length = 4
# } 

# resource "google_storage_bucket" "simple-pipeline-artifact" {
#   name = "simple-pipeline-artifact-${random_id.instance_name_suffix.byte_length}"
#   location      = var.location
#   project       = "lab-project-282605"
# }


# resource "google_storage_default_object_access_control" "public_rule" {
#   bucket = google_storage_bucket.simple-pipeline-artifact.name
#   role   = "READER"
#   entity = var.entity
#   depends_on = [google_storage_bucket.simple-pipeline-artifact]
# }