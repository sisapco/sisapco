$(document).ready(function () {
    $('#dataTable').DataTable({
        search: {
            return: true,
        },
        order: {
        	return: [[ 0, 'asc' ]]
        }, 
    });
});
