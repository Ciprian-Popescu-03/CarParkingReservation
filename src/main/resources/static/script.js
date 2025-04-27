
function searchByLocation() {
    const location = prompt("Enter location:");
    if (location) {
    window.location.href = `/search?location=${location}`;
}
}

function searchByAvailability() {
    const availability = confirm("Show only available spaces?");
    if (availability) {
    window.location.href = `/search?available=true`;
} else {
    window.location.href = `/search?available=false`;
}
}

