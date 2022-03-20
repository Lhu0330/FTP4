var AppCalendar = (function() {
	var calendar = null;
	var containerEl = document.getElementById("event_box");	// 별도로 이벤트를 Drag&Drop 하기 위한 영역
	var calendarEl = document.getElementById("calendar");

	function initCalendar() {
		new FullCalendar.Draggable(containerEl, {
			itemSelector: ".external-event",
			eventData: function(eventEl) {
				return {
					title: eventEl.innerText.trim()
				}
			}
		});

		calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar: {
				left: 'prevYear,prev,next,nextYear today',
				center: 'title',
				right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
			}
			, locale: "ko"
			, weekNumbers: true
			, businessHours: true
			, navLinks: true
			, editable: true
			, dayMaxEvents: true
			, selectable: true
			, select: function(arg) {
				var title = prompt("Event Title:");
				if (title) {
					calendar.addEvent({
						title: title,
						start: arg.start,
						end: arg.end,
						allDay: arg.allDay
					})
				}
				calendar.unselect();
			}
			, unselect: function(arg) {}
			, droppable: true
			, drop: function(arg) {
				if ($("#drop-remove").is(":checked")) {
					arg.draggedEl.remove();
				}
			}
			, eventReceive: function(arg) {
				AppCalendar.saveEvent("in", arg);
			}
			, eventClick: function(arg) {
				if (confirm("일정을 삭제하시겠습니까?")) {
					arg.event.remove()
				}
			}
			, eventAdd: function(arg) {
				AppCalendar.saveEvent("in", arg);
			}
			, eventChange: function(arg) {
				AppCalendar.saveEvent("up", arg);
			}
			, eventRemove: function(arg) {
				AppCalendar.delEvent(arg);
			}
			, eventSources: [ {
				url: "ajax URL"
				, method: "POST"
				, extraParams: {
					mode: "schedule"
					, act: "list"
				}
			} ]
		});

		calendar.render();
	}

	return {
		addEvent: function(title) {
			if(title.length > 0) {
				title = title.length === 0 ? "Untitled Event" : title;
				var html = $('<div class="external-event label label-default">' + title + '</div>');
				jQuery("#event_box").append(html);
			}
		},

		saveEvent: function(act, arg) {
			var allday = arg.event.allDay ? 1 : 0;
			$.post("ajax URL", { "idx" : arg.event.groupId, "title" : arg.event.title, "start" : arg.event.startStr, "end" : arg.event.endStr, "alldate" : allday, "act" : "proc", "mode" : "schedule" }, function (data) {
				if (data.Result == "ok") {
					if (act == "in") {
						arg.event.setProp( "groupId", data.idx );	// 신규 추가된 일정의 일련번호
						//arg.event.setExtendedProp( "idx", "123123" );
					}
				}else{
					alert("일정 저장중 오류가 발생하였습니다.");
				}
			}, "json");
		},

		delEvent: function(arg) {
			var allday = event.allDay ? 1 : 0;
			$.post("ajax URL", { "idx" : arg.event.groupId, "title" : arg.event.title, "start" : arg.event.startStr, "end" : arg.event.endStr, "alldate" : allday, "act" : "delete", "mode" : "schedule" }, function (data) {
				if (data.Result == "ok") {
				}else{
					alert("일정 삭제중 오류가 발생하였습니다.");
				}
			}, "json");
		},

		//main function to initiate the module
		init: function() {
			initCalendar();
		}

	};

}());
