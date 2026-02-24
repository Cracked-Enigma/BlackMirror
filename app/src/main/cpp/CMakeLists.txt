cmake_minimum_required(VERSION 3.22.1)

project("blackmirror")

add_library(blackmirror SHARED
        native-lib.cpp)

# Force 16KB ELF page alignment (Android 15+ requirement)
target_link_options(blackmirror PRIVATE
        "-Wl,-z,max-page-size=16384"
)

find_library(log-lib log)

target_link_libraries(blackmirror
        android
        ${log-lib})